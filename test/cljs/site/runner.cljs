(ns site.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [site.components.tabbed-view-test]))

(doo-tests 'site.components.tabbed-view-test)
