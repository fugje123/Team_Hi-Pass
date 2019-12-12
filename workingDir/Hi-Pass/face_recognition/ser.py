import RPi.GPIO as GPIO
import time

pin = 18

GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)

p = GPIO.PWM(pin, 50)
p.start(0)
cnt = 0

def detectionmode():
    p.ChangeDutyCycle(10)
    time.sleep(1)

def trackingmode():
    p.ChangeDutyCycle(7.5)
    time.sleep(1)


def cleanup():
    p.stop()
    GPIO.cleanup()
