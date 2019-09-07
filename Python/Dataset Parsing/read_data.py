import matplotlib.pyplot as plt
import numpy as np
import csv
import pandas as pd

# ['video_id', 'trending_date', 'title', 'channel_title', 'category_id', 'publish_time',
# 'tags', 'views', 'likes', 'dislikes', 'comment_count', 'thumbnail_link', 'comments_disabled', 
# 'ratings_disabled', 'video_error_or_removed', 'description']

def open_file():
    file  = 'USvideos.csv'
    
    data = pd.read_csv(file)
    # print(data.sort_values(by='video_error_or_removed', ascending=False))
    
    info = (data.drop(['video_id', 'thumbnail_link'], axis=1))

    info = info[:20].sort_values(by='views')
    print(info['views'])

    # info.plot(kind='line', x='views', y='comment_count', color='red')

    plt.show()


if __name__ == "__main__":
    open_file()