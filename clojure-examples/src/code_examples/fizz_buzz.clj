(ns code-examples.fizz-buzz)

(defn divisible-by? [divisor number]
  (= 0 (mod number divisor)))

(defn fizz-buzzify [number]
  (cond
    (divisible-by? 15 number) "fizzbuzz"
    (divisible-by? 3 number) "fizz"
    (divisible-by? 5 number) "buzz"
    :else number))

(def fizz-buzz (map fizz-buzzify (range)))

(mapv println (take 100 fizz-buzz))

