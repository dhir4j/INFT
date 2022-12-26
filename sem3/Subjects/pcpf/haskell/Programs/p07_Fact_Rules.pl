likes(dan,sally).
likes(josh,brittney).
dating(X,Y):-likes(X,Y),likes(Y,X).
friendship(X,Y):-likes(X,Y);likes(Y,X).