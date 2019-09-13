import matplotlib.pyplot as plt
import seaborn as sns
sns.set() # setting seaborn default for plots
import pandas as pd

# .isnull().sum()
# 

def bar_chart(feature):
    survived = train[train['Survived']==1][feature].value_counts()      # holds values where Survived==1 AND y is the feature
    dead = train[train['Survived']==0][feature].value_counts()      # holds values where Survived==1 AND y is the feature
    df = pd.DataFrame([survived,dead])      # DataFrame var with [survived, dead] as its (x) components
    df.index = ['Survived','Dead']      # Create titles for each 
    df.plot(kind='bar',stacked=True, figsize=(10,5))        # create a stacked bar graph
    plt.show()      # show the graph

if __name__ == "__main__":
    test = pd.read_csv('test.csv')
    train = pd.read_csv('train.csv')

    # bar_chart('Embarked')

    train_test_data = [train, test] # combining train and test dataset

    for dataset in train_test_data:     # loop through both datasets
        dataset['Title'] = dataset['Name'].str.extract(' ([A-Za-z]+)\.', expand=False)

    bar_chart('SibSp')