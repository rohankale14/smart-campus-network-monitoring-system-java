import subprocess
import json
import re
import random
import time

# store temporary hotspot-like networks
last_seen = {}

def get_latency():
    try:
        output = subprocess.check_output(
            ["ping", "-n", "1", "8.8.8.8"],
            encoding="utf-8",
            errors="ignore"
        )
        match = re.search(r'time[=<]\s*(\d+)', output)
        if match:
            return int(match.group(1))
    except:
        pass

    return 0   # keep visible


def scan_wifi():
    global last_seen

    output = subprocess.check_output(
        ["netsh", "wlan", "show", "networks", "mode=bssid"],
        encoding="utf-8",
        errors="ignore"
    )

    networks = []
    current_ssids = set()

    ssid = None
    signal = 0
    channel = 0

    for line in output.split("\n"):
        line = line.strip()

        # SSID
        if "SSID" in line and "BSSID" not in line:
            parts = line.split(":")
            if len(parts) > 1:
                ssid = parts[1].strip() or "HIDDEN_NETWORK"

        # SIGNAL (read real value first)
        elif "Signal" in line:
            signal = int(line.split(":")[1].replace("%", "").strip())
            signal = max(0, min(100, signal))

        # CHANNEL + FINAL NETWORK DATA
        elif "Channel" in line and ssid is not None:
            channel_str = line.split(":")[1].strip()
            channel = int(re.search(r'\d+', channel_str).group())

            # 📱 mobile hotspot candidate logic only
            is_hotspot = channel in [1, 6, 11] and signal > 35

            # ✅ random fluctuation only for routers
            if not is_hotspot:
                signal += random.randint(-2, 2)
                signal = max(0, min(100, signal))

            latency = get_latency()

            # anomaly logic
            if signal < 30 or latency > 200:
                anomaly = "CRITICAL"
                status = "ABNORMAL"
            elif signal < 50 or latency > 120:
                anomaly = "WEAK"
                status = "ABNORMAL"
            elif signal < 70:
                anomaly = "MODERATE"
                status = "NORMAL"
            else:
                anomaly = "STRONG"
                status = "NORMAL"

            current_ssids.add(ssid)
            last_seen[ssid] = time.time()

            networks.append({
                "ssid": ssid,
                "signal": signal,
                "channel": channel,
                "latency": latency,
                "anomaly": anomaly,
                "status": status,
                "isHotspot": is_hotspot
            })

            ssid = None

    # ✅ remove stale hotspot-like entries after 5 sec only
    now = time.time()
    filtered_networks = []

    for net in networks:
        if net["isHotspot"]:
            if now - last_seen.get(net["ssid"], now) <= 5:
                filtered_networks.append(net)
        else:
            filtered_networks.append(net)

    return filtered_networks


if __name__ == "__main__":
    print(json.dumps(scan_wifi()))