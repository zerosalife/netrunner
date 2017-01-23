(ns netrunner.core
  (:require [reagent.core :as r]
            [goog.dom]))

(def by-id goog.dom.getElement)

(defonce app-state (r/atom {:page :home}))

(defn home-page []
  (let [button-disabled (r/atom false)]
    (fn []
      [:button {:className "cooldownButton"
                :disabled @button-disabled
                :on-click #(do
                             (swap! button-disabled not)
                             (js/setTimeout (fn [] (swap! button-disabled (fn [] false))) 3000)
)}])))

(defmulti current-page #(@app-state :page))
(defmethod current-page :home []
  [home-page])

(r/render-component [current-page] (by-id "app"))
