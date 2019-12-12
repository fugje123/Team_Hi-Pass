import time
import os
import webbrowser
import socket
import random



f = open("/home/pi/Hi-Pass/python-docs-samples/speech/microphone/nlp_result.txt","r")

text = (f.read()).split(' ')

for i in text:
    if 'turn' in i:
        for j in text:
            if 'mus' in j:
                    webbrowser.open("https://www.youtube.com/watch?v=C9zOz6NkiYg")
            if 'light' in j:
                    HOST = '192.168.112.92'
                    PORT = 12345
                    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
                    s.connect((HOST,PORT))
                    sbuff=str('1').encode("utf-8")
                    print(sbuff)
                    s.send(sbuff)
                    s.close()

    if 'stop' in i:
        for j in text:
            if 'mus' in j:
                os.system("pkill chromium")

    if 'weath' in i:
        for j in text:
            if 'today' in j:
                os.system("python3 ~/Hi-Pass/python-docs-samples/speech/microphone/weather.py")
                os.system("mpg321 weather.mp3")
            ## motor access need to turning on light using tts -youngjun-
    if 'tim' in i:
        for j in text:
            if '' in j:
                os.system("python3 ~/Hi-Pass/python-docs-samples/speech/microphone/time.py")
                os.system("mpg321 time.mp3")
    if 'wikiped' in i:
        for j in text:
            if '' in j:
                print('search...')
                os.system("python3 /home/pi/Hi-Pass/python-docs-samples/speech/microphone/strsplit.py")
                os.system("python3 /home/pi/Hi-Pass/python-docs-samples/speech/microphone/wiki.py")
                break
    if 'beat' in i:
        for j in text:
            if 'box' in j:
                print('beatbox!')
                os.system("python3 /home/pi/Hi-Pass/python-docs-samples/speech/microphone/beatbox.py")
    if 'tel' in i:
        for j in text:
            if 'funny' in j:
                print('funny!')
                sampleList = ['a', 'b', 'c', 'd']
                flist = (random.choice(sampleList)) 
                if flist == 'a':
                    os.system('mpg321 funny.mp3')
                if flist == 'b':
                    os.system('mpg321 funny2.mp3')
                if flist == 'c':
                    os.system('mpg321 funny3.mp3')
                if flist == 'd':
                    os.system('mpg321 funny4.mp3')
f.close()
os.system("python /home/pi/Hi-Pass/python-docs-samples/speech/microphone/transcribe_streaming_mic.py")

