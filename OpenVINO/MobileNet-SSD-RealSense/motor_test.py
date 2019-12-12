import RPi.GPIO as GPIO
import time

t = 0.01

Motor_IN1 = 19
Motor_IN2 = 13
Motor_IN3 = 6
Motor_IN4 = 5
Enable_A = 26
Enable_B = 0
GPIO.setmode(GPIO.BCM)
GPIO.setup(Motor_IN1, GPIO.OUT)
GPIO.setup(Motor_IN2, GPIO.OUT)
GPIO.setup(Motor_IN3, GPIO.OUT)
GPIO.setup(Motor_IN4, GPIO.OUT)
GPIO.setup(Enable_A, GPIO.OUT)
GPIO.setup(Enable_B, GPIO.OUT)
pwm_e1 = GPIO.PWM(Enable_A, 500)
pwm_e2 = GPIO.PWM(Enable_B, 500)
pwm_e1.start(0)
pwm_e2.start(0)

def brake():
   pwm_e1.ChangeDutyCycle(10)
   pwm_e2.ChangeDutyCycle(10)
   GPIO.output(Motor_IN1, False)
   GPIO.output(Motor_IN2, True)
   GPIO.output(Motor_IN3, False)
   GPIO.output(Motor_IN4, True)
   time.sleep(t)
   GPIO.output(Motor_IN1, False)
   GPIO.output(Motor_IN2, False)
   GPIO.output(Motor_IN3, False)
   GPIO.output(Motor_IN4, False)
   print("BR")

def stop():
   pwm_e1.ChangeDutyCycle(100)
   pwm_e2.ChangeDutyCycle(100)
   GPIO.output(Motor_IN1, False)
   GPIO.output(Motor_IN2, False)
   GPIO.output(Motor_IN3, False)
   GPIO.output(Motor_IN4, False)
   print("s")

def forward_1():
   pwm_e1.ChangeDutyCycle(40)
   pwm_e2.ChangeDutyCycle(40)
   GPIO.output(Motor_IN1, True)
   GPIO.output(Motor_IN2, False)
   GPIO.output(Motor_IN3, True)
   GPIO.output(Motor_IN4, False)
   print("F_L")
   time.sleep(t)

def forward_2():
   pwm_e1.ChangeDutyCycle(100)
   pwm_e2.ChangeDutyCycle(100)
   GPIO.output(Motor_IN1, True)
   GPIO.output(Motor_IN2, False)
   GPIO.output(Motor_IN3, True)
   GPIO.output(Motor_IN4, False)
   print("F_F")
   time.sleep(t)

def Reverse():
   pwm_e1.ChangeDutyCycle(45)
   pwm_e2.ChangeDutyCycle(45)
   GPIO.output(Motor_IN1, False)
   GPIO.output(Motor_IN2, True)
   GPIO.output(Motor_IN3, False)
   GPIO.output(Motor_IN4, True)
   print("Re")
   time.sleep(t)

def turnRight():
   pwm_e1.ChangeDutyCycle(100)
   pwm_e2.ChangeDutyCycle(100)
   GPIO.output(Motor_IN1, True)
   GPIO.output(Motor_IN2, False)
   GPIO.output(Motor_IN3, False)
   GPIO.output(Motor_IN4, True)
   print ("T_R")
   time.sleep(t)

def turnLeft():
   pwm_e1.ChangeDutyCycle(100)
   pwm_e2.ChangeDutyCycle(100)
   GPIO.output(Motor_IN1, False)
   GPIO.output(Motor_IN2, True)
   GPIO.output(Motor_IN3, True)
   GPIO.output(Motor_IN4, False)
   print("T_L")
   time.sleep(t)

def cleanup():
   stop()  
   pwm_e1.stop()
   pwm_e2.stop()
   GPIO.cleanup()
