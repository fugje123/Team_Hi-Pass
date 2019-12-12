from urllib.request import urlopen, Request
from gtts import gTTS
import urllib
import bs4

location = '안서동'
enc_location = urllib.parse.quote(location + '+날씨')

url = 'https://search.naver.com/search.naver?ie=utf8&query='+ enc_location

req = Request(url)
page = urlopen(req)
html = page.read()
soup = bs4.BeautifulSoup(html,'html5lib')

tts=gTTS(text=' 현재 '+location+'온도는 '+soup.find('p', class_='info_temperature').find('span', class_='todaytemp').text+' 도로 '+soup.find('ul', class_='info_list').find('p', class_='cast_txt').text,lang='ko')

tts.save("weather.mp3")