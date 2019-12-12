#-*- coding: utf-8 -*-

import socket
import struct
import time

port = 5515

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind(('',port))

print("server start")

while True:
    data, info = sock.recvfrom(55555)
    checkWarning=open('/home/pi/workingDir/ppinfo.txt','a')
    checkWarning.write(data.encode('utf-8'))
    checkWarning.close()
    continue
