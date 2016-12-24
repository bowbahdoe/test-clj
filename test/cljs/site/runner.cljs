(ns site.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [site.general-test]
              [site.types-test]
              [site.components.tabbed-view-test]
              [site.components.navbar-test]))

(doo-tests  'site.general-test
            'site.types-test
            'site.components.tabbed-view-test
            'site.components.navbar-test)
