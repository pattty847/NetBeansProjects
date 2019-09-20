import pandas as pd
import matplotlib.pyplot as plt



if __name__ == "__main__":
    data = pd.read_csv(r'C:\Users\pattt\Documents\Coding\Python\machine learning\crime.csv', encoding='cp1252')

    # Mapping for days of the week to number format 0-6
    day_mapping = {"Sunday": 0, "Monday": 1, "Tuesday": 2,
    "Wednesday": 3, "Thursday": 4, "Friday": 5, "Saturday": 6}

    # Getting rif of this data
    data.drop(['Lat', 'Long', 'UCR_PART', 'INCIDENT_NUMBER', 
    'REPORTING_AREA', 'SHOOTING', 'Location', 
    'OCCURRED_ON_DATE'], axis=1, inplace=True)

    # Fill all NaN with 'D0' for 'District 0'
    data["DISTRICT"].fillna('D0', inplace=True)

    # Convert days of week to their numeric values
    data['DAY_OF_WEEK'] = data['DAY_OF_WEEK'].map(day_mapping)

    data.sort_values(by='OFFENSE_DESCRIPTION', inplace=True)

    inputs = data[data['DAY_OF_WEEK']['OFFENSE_CODE_GROUP']=='Larceny'].value_counts()
    plt.plot(inputs)
    plt.show()