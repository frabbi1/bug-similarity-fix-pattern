# import required libraries
import numpy as np
from numpy.linalg import norm
import csv


def calculate_cosine_similarity(A,B):
    return np.dot(A,B)/(norm(A)*norm(B))


rows = []
projects = []
with open("../output/cosine_vector.csv", 'r') as file:
    csvreader = csv.reader(file)
    for row in csvreader:
        projects.append(row[0])
        rows.append(row[1:])

# print(projects)
for r in rows:
    for i in range(0,r.__len__()):
        r[i] = int(r[i])


h = projects[:]
h.insert(0,'#')

table = [h]
for idx1,p in enumerate(rows):
    t_row = [projects[idx1]]
    for idx2,q in enumerate(rows):
        A = np.array(p)
        B = np.array(q)
        score = calculate_cosine_similarity(A,B)
        t_row.append(score)
        print(projects[idx1],projects[idx2])
        print(score)
    table.append(t_row)
#print(table)        
with open("../output/cosine_similarity_score.csv", "w") as f:
    writer = csv.writer(f)
    writer.writerows(table)

# print(projects[0])
# print(projects[2])

# # # compute cosine similarity
# cosine = np.dot(A,B)/(norm(A)*norm(B))
# print("Cosine Similarity:", cosine)


