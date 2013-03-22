(ns code-examples.recursion)

(defn length
  ([collection]
   (length collection 0))
  ([collection accumulator]
   (if (empty? collection)
     accumulator
     (recur (rest collection) (inc accumulator)))))

