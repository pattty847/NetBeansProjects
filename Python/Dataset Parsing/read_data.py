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

    title_mapping = {"Mr": 0, "Miss": 1, "Mrs": 2, 
                 "Master": 3, "Dr": 3, "Rev": 3, "Col": 3, "Major": 3, "Mlle": 3,"Countess": 3,
                 "Ms": 3, "Lady": 3, "Jonkheer": 3, "Don": 3, "Dona" : 3, "Mme": 3,"Capt": 3,"Sir": 3 }

    sex_mapping = {"female": 0, "male": 1}

    # bar_chart('Embarked')

    train_test_data = [train, test] # combining train and test dataset

    for dataset in train_test_data:     # loop through both datasets

        # (' ([A-Za-z]+)/.') <-- find all letters a-z or A-Z that end with a (.)
        dataset['Title'] = dataset['Name'].str.extract(' ([A-Za-z]+)\.', expand=False)

        # create a new column that maps their titles to a 1, 2, or 3
        dataset['Title'] = dataset['Title'].map(title_mapping)

        # map their sex to a 0 or 1
        dataset['Sex'] = dataset['Sex'].map(sex_mapping)

        dataset.loc[ dataset['Age'] <= 16, 'Age'] = 0,
        dataset.loc[(dataset['Age'] > 16) & (dataset['Age'] <= 26), 'Age'] = 1,
        dataset.loc[(dataset['Age'] > 26) & (dataset['Age'] <= 36), 'Age'] = 2,
        dataset.loc[(dataset['Age'] > 36) & (dataset['Age'] <= 62), 'Age'] = 3,
        dataset.loc[ dataset['Age'] > 62, 'Age'] = 4

        dataset['Embarked'] = dataset['Embarked'].fillna('S')

    # fill all NaNs with a median age for their title across the whole dataset (title_mapping)
    train["Age"].fillna(train.groupby("Title")["Age"].transform("median"), inplace=True)
    test["Age"].fillna(test.groupby("Title")["Age"].transform("median"), inplace=True)

    train["Fare"].fillna(train.groupby("Pclass")["Fare"].transform("median"), inplace=True)
    test["Fare"].fillna(test.groupby("Pclass")["Fare"].transform("median"), inplace=True)

    # get rid of the column 'Name'
    test.drop('Name', axis=1, inplace=True)
    train.drop('Name', axis=1, inplace=True)

    bar_chart('Age')