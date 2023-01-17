flip zip [1,2,3,4,5] "hello"

map (+3) [1,4,5,3,2]

applyTwice f x = f (f x)
applyTwice (+3) 10

applyTwice (++"HAHA") "HEY"
applyTwice ("HAHA"++) "HEY"
