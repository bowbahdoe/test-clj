(ns site.components.tabbed-view
  (:require [re-frame.core :as re-frame]
            [re-com.core :as re-com]
            [site.general :refer [enumerate]]))

;; ----------------------------------------------------------------------------
;; N, HTML -> HTML
;; Returns a view of the given content that will only render if
;; the :current-tab is the same as tab-number, and will not render
;; otherwise

(defn tabbed-content [tab-number content]
  (let [tab (re-frame/subscribe [:current-tab])]
    (if (= @tab tab-number)
      [:div content]
      [:div {:style {:display "none"}}
            content])))

;; ----------------------------------------------------------------------------
;; N -> |nil -> nil|
;; returns a function that sets the current tab to
;; the one given by N

(defn make-switcher [N]
  (fn [] (re-frame/dispatch [:change-tab N])))

;; ----------------------------------------------------------------------------
;; N -> HTML
;; Returns an HTML representation of a tab
;; switcher with N tabs

(defn tab-selector [N]
  (let [tab (re-frame/subscribe [:current-tab])]
    [re-com/h-box
      :gap "100px"
      :children
      (let [t @tab]
        (for [i (range N)]
            ^{:key i}
            (if (= i t)
                [:h1 {:style {:color "red"}}
                    (str "Tab " i)]
                [:h1 {:on-click (make-switcher i)}
                     (str "Tab " i)])))]))

;; ----------------------------------------------------------------------------
;; & HTML -> HTML
;; Makes a representation of a tabbed-view in HTML using the children
;; passed

(defn tabbed-view [& children]
  [:div
    [tab-selector (count children)]
    (for [[index child] (enumerate children)]
       ^{:key index}
       [tabbed-content index child])])
