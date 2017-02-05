(ns site.components.navbar
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [reagent.core :as r]
              [reagent.interop :refer-macros [$]]
              [cljs-react-material-ui.core :refer [get-mui-theme color]]
              [cljs-react-material-ui.reagent :as ui]
              [site.general :refer [give-indexed-keys]]))

;; ----------------------------------------------------------------------------
;; A Nav-Item-Description is a
;; -- {:label String
;;     :link String}

;; where :label is the Text that will appear on that nav-button
;; and :link is the href to which that nav points

;; ----------------------------------------------------------------------------
;; A Nav-Dropdown-Description is a
;; -- {:title String
;;     :contents |Sequence Nav-Description|

;; ----------------------------------------------------------------------------
;; A Nav-Description one of
;; -- Nav-Item-Description
;; -- Nav-Dropdown-Description

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
  [ui/list-item
    {:primaryText (:label button-desc)
     :href (:link button-desc)}])

;; ----------------------------------------------------------------------------
;; Nav-Dropdown-Description -> HTML
;; renders the given Nav-Dropdown-Description to HTML
(defn render-dropdown [dropdown-desc]
  [ui/list-item
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

;; nil -> HTML
;; generates a login button
(defn login-button []
  [ui/flat-button {:label "Login"}])

;; ----------------------------------------------------------------------------
;; String & Nav-Description -> HTML
;; Takes the Title for the nav-bar and a variable number of Nav-Descriptions
;; and renders a basic navbar
(defn navbar [title & descs]
  (let [open? (re-frame/subscribe [:navbar-expanded?])]
    (fn [title & descs]
        [:div
          [ui/app-bar
                    {:title title
                     :onLeftIconButtonTouchTap toggle-nav
                     :iconElementRight (r/as-element (login-button))}]
            [ui/drawer
                       {:docked false
                        :width 200
                        :open @open?
                        :onRequestChange toggle-nav}
              [ui/list
                (give-indexed-keys (map render-nav-element descs))]]])))
