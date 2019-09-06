import matplotlib.pyplot as plt
import numpy as np
import csv

# ['video_id', 'trending_date', 'title', 'channel_title', 'category_id', 'publish_time',
# 'tags', 'views', 'likes', 'dislikes', 'comment_count', 'thumbnail_link', 'comments_disabled', 
# 'ratings_disabled', 'video_error_or_removed', 'description']

def open_file():
    file  = 'USvideos.csv'
    
    with open(file, 'r') as f:
        reader = csv.reader(f, delimiter=',')
        headers = next(reader)
        data = list(reader)
        data = np.array(data)
    

    print(headers)


if __name__ == "__main__":
    open_file()