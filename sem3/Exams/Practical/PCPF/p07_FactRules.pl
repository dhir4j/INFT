likes(dan,sally).
likes(sally,dan).
likes(juliet,butcher).
dating(X,Y):-likes(X,Y),likes(Y,X).
friendship(X,Y):-likes(X,Y);likes(Y,X).

Query:
friendship(a,b).
""(b,a).
likes().
dating().
