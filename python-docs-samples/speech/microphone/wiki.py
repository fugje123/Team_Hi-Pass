import wikipediaapi
import os
from gtts import gTTS

wiki=wikipediaapi.Wikipedia('ko')
f = open("/home/pi/Hi-Pass/python-docs-samples/speech/microphone/laststr.txt","r")
lastword = f.read()
f.close()

page_py = wiki.page(lastword)
text2 = page_py.exists()

if text2 == False:
    tts=gTTS(text='검색 결과가 없습니다', lang='ko')
    tts.save("wikif.mp3")
    os.system("mpg321 wikif.mp3")
else:
    text3 = page_py.summary[0:80]
    tts=gTTS(text=text3,lang='ko')
    tts.save("wiki.mp3")
    os.system("mpg321 wiki.mp3")
