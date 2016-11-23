(ns netrunner.core
  (:require [reagent.core :as r]
            [goog.dom]))

(def by-id goog.dom.getElement)

(defonce app-state (r/atom {:page :home}))

(defn home-page []
  [:div ])

(defmulti current-page #(@app-state :page))
(defmethod current-page :home []
  [home-page])

(r/render-component [current-page] (by-id "app"))
