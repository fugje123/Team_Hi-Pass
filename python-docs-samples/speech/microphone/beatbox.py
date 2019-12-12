from gtts import gTTS
import os

tts=gTTS(text='요즘 연습중인 비트박스에요 북치기 박치기 북치기박치기북치기박치기 북치기 박치기 북 북 북 어때요?', lang='ko')
tts.save("beatbox.mp3")
os.system("mpg321 beatbox.mp3")