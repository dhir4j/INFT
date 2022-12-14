natSum :: Int -> Int
natSum 0 = 0
natSum n = n + natSum (n-1)