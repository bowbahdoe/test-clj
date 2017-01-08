(ns site.components.navbar
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [reagent.core :as r]
              [reagent.interop :refer-macros [$]]
              [site.dependencies :refer [material-ui]]
              [site.general :refer [give-indexed-keys]]))

;; ----------------------------------------------------------------------------
;; A Nav-Item-Description is a
;; -- {:label String
;;     :link String}

;; ----------------------------------------------------------------------------
;; A Nav-Dropdown-Description is a
;; -- {:title String
;;     :contents |Sequence Nav-Description|

;; ----------------------------------------------------------------------------
;; A Nav-Description one of
;; -- Nav-Item-Description
;; -- Nav-Dropdown-Description

;; where :title is the Text that will appear on that nav-button
;; and :link is the href to which that nav points
;; ----------------------------------------------------------------------------

(declare render-nav-element)
;; ----------------------------------------------------------------------------
;; Nav-Description -> Boolean
;; returns whether a given nav-description is a dropdown
(defn dropdown? [nav-description]
  (not (= nil (:contents nav-description))))

;; ----------------------------------------------------------------------------
;; Nav-Item-Description -> HTML
;; Renders the given description of a nav button as HTML
(defn render-button [button-desc]
    [:> ($ material-ui :ListItem)
        {:primaryText (:title button-desc)
        :href (:link button-desc)}])

;; ----------------------------------------------------------------------------
;; Nav-Dropdown-Description -> HTML
;; renders the given Nav-Dropdown-Description to HTML
(defn render-dropdown [dropdown-desc]
  [:> ($ material-ui :ListItem)
    {:primaryText (:title dropdown-desc)
                 :initiallyOpen false
                 :primaryTogglesNestedList true
                 :nested-items (map r/as-element
                                  (give-indexed-keys
                                    (map render-nav-element
                                      (:contents dropdown-desc))))}])

;; ----------------------------------------------------------------------------
;; Nav-Description -> HTML
;; Renders the given Nav-Description
(defn render-nav-element [nav-description]
  (if (dropdown? nav-description)
    (render-dropdown nav-description)
    (render-button nav-description)))

;; nil -> nil
;; Dispatches the :toggle-navbar-expansion event
(def toggle-nav #(re-frame/dispatch [:toggle-navbar-expansion]))

;; ----------------------------------------------------------------------------
;; String & Nav-Description -> HTML
;; Takes the Title for the nav-bar and a variable number of Nav-Descriptions
;; and renders a basic navbar
(defn navbar [title & descs]
  (let [open? (re-frame/subscribe [:navbar-expanded?])]
    (fn [title & descs]
      [:> ($ material-ui :MuiThemeProvider)
        [:div
          [:> ($ material-ui :AppBar)
                    {:title title
                     :onLeftIconButtonTouchTap toggle-nav}]
            [:> ($ material-ui :Drawer)
                       {:docked false
                        :width 200
                        :open @open?
                        :onRequestChange toggle-nav}
              [:> ($ material-ui :List)
                (give-indexed-keys (map render-nav-element descs))]]]])))
