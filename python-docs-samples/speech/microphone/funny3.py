from gtts import gTTS
import os

tts=gTTS(text='소랑 개랑 부딪히면? 소개팅  하 하 하 하 하 ', lang='ko')
tts.save("funny3.mp3")
