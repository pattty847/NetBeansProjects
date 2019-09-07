import matplotlib.pyplot as plt
import numpy as np
import csv
import seaborn
import pandas as pd


# np.array[row, col]

def open_file():
    file  = r'C:\Users\pattt\Documents\NetBeansProjects\Python\Dataset Parsing\train.csv'
    
    with open(file, 'r') as f:
        reader = csv.reader(f, delimiter=',')
        # get header from first row
        headers = next(reader)
        # get all the rows as a list
        data = list(reader)
        # transform data into numpy array
        data = np.array(data)

    data[1:20, 5].sort()

    plt.scatter(data[1:20, 5], data[1:20, 1])
    plt.show()

if __name__ == "__main__":
    open_file()