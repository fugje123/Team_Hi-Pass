#-*- coding: utf-8 -*-

import socket
import struct
import time
import os

port = 5514

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind(('',port))

print("server start")

while True:
	data, info = sock.recvfrom(55555)
	checkWarning = open('/home/pi/workingDir/info.txt','r')
	warningData = checkWarning.read()
	print(warningData)
	print("recive data :" + data.decode())
	if data.decode() == 'Audio On':
		print("Audio Mode On")
		#os.system("sudo ./process.sh")
		continue
	if data.decode() == 'Audio Off':
		print("Audio Mode Off")
		#os.system("sudo python /home/pi/yyy.py")
		continue
	if data.decode() == 'Security Mode':
		if warningData == '1':
			sock.sendto(data, info)
			print("WARNING")
			checkWarning.close()
			time.sleep(20)
			continue
		if warningData == '0':
			safe = 'safe'.encode()
			sock.sendto(safe, info)
			print("SAFE")
			checkWarning.close()
			time.sleep(20)
			continue

