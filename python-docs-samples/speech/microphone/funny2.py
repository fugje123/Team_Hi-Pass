from gtts import gTTS
import os

tts=gTTS(text='공이 웃으면?     풋 볼     하 하 하 하 하', lang='ko')
tts.save("funny2.mp3")
