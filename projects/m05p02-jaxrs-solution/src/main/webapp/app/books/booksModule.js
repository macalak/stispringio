/**
 * Created by pittner on 21.11.2015.
 */

angular.module('library.books', [])

    .config(function ($stateProvider, $urlRouterProvider) {
        'use strict';

        $stateProvider

            .state('library', {
                url: '/library',
                redirectTo: 'library.books'
            })

            .state('library.books', {
                url: '/books',
                views: {
                    "@": {
                        controller: 'BooksCtrl',
                        templateUrl: 'app/books/views/books.html'
                    }
                }
            })

            .state('library.books.book', {
                url: '/:id',
                views: {
                    "@": {
                        controller: 'BookCtrl',
                        templateUrl: 'app/books/views/book.html'
                    }
                }
            });

        $urlRouterProvider.otherwise('/library/books');
    })
;
