(ns code-examples.mutation)

(def logan
  {:name "Logan" :age 25 :hair "brown"}) 

(assoc logan :age 26)

logan

(def older-logan
  (assoc logan :age 26))

(def greying-logan
  (assoc logan :hair "greying brown"))

greying-logan

(-> logan
    (assoc :age 26)
    (assoc :hair "greying brown"))

(def birthdays-worth-celebrating
  [1 2 10 13 15 16 18 21 30 50 100])

(cons 0 birthdays-worth-celebrating)

birthdays-worth-celebrating

(def family 
  [{:name "mum" :age 30}
   {:name "dad" :age 32}
   {:name "baby" :age 0}])

(map (fn [member] (update-in member [:age] inc)) family)

