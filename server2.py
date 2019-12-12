import socket
import os
import time
import RPi.GPIO as GPIO


HOST = '192.168.112.92'
# Server IP or Hostname
PORT = 12345
# Pick an open Port (1000+ recommended), must match the client sport
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

#managing error exception
try:
	s.bind((HOST, PORT))
except socket.error:
	print 'Bind failed '

s.listen(5)
print 'Socket awaiting messages'
(conn, addr) = s.accept()
print 'Connected'

d=open('/home/pi/info.txt','r')

pin = 18

GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)
p = GPIO.PWM(pin,50)
p.start(0)
p.ChangeDutyCycle(0)
tmp = d.read()

# awaiting for message
while True:
	data = conn.recv(1024)
	print 'I sent a message back in response to: ' + data
	# process your message
	if data == '1':
		print 'YES'
		print (tmp)
		if tmp == '0':
    			f=open('/home/pi/info.txt','w')
    			f.write('1')
    			p.ChangeDutyCycle(0.25)
    			time.sleep(0.2)
    			p.ChangeDutyCycle(0)
    			f.close()
    			d.close()
		if tmp == '1' :
    			f=open('/home/pi/info.txt','w')
    			f.write('0')
    			p.ChangeDutyCycle(4)
    			time.sleep(0.2)
    			p.ChangeDutyCycle(0)
    			f.close()
    			d.close()

		s.close();
		break
	#and so on and on until...
	elif data == 'quit':
		conn.send('Terminating')
		break
	else:
		break
GPIO.cleanup()
conn.close()
os.system("python /home/pi/server.py")
#Close connectio
