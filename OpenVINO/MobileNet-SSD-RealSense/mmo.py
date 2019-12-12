import RPi.GPIO as GPIO
import time

pin = 18

GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)

p = GPIO.PWM(pin, 50)
p.start(0)
cnt = 0

def detectionmode():
    print("DetectionMode")
    p.ChangeDutyCycle(12)
    time.sleep(1)

def trackingmode():
    print("TrackingMode")
    p.ChangeDutyCycle(7.5)
    time.sleep(1)


def cleanup():
    p.stop()
    GPIO.cleanup()
