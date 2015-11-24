/**
 * Created by pittner on 21.11.2015.
 */

angular.module('libraryApp', [
        'ngResource',
        'ui.router',
        'library.books'
    ])

    .run(function ($rootScope, $state) {
        $rootScope.$on('$stateChangeStart', function (evt, to, params) {
            if (to.redirectTo) {
                evt.preventDefault();
                $state.go(to.redirectTo, params)
            }
        })
    })
;
