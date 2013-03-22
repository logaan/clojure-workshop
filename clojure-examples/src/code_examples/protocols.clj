(ns code-examples.protocols)

(def tax-rate 0.1)

(defprotocol Taxable
  (tax-amount [item]))

(defrecord Product [price name]
  Taxable
  (tax-amount [product]
   (* (:price product) tax-rate)))

(defrecord ServiceType [rate])

(defrecord Service [type hours discount description]
  Taxable
  (tax-amount [service]
    (let [price      (* (:hours service) (:rate (:type service)))
          discounted (- price (:discount service))]
    (* discounted tax-rate))))

(def purchases 
  [(Product. 500 "Row boat")
   (Service. (ServiceType. 60) 2 10 "Hair cut")])

(apply + (map tax-amount purchases))
; => 61.0

