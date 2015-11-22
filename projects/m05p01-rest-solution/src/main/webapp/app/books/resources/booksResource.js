angular.module('library.books')

    .factory('BooksResource', function ($resource) {
        'use strict';

        return $resource('library/api/books', {}, {
            query: {
                method: 'GET',
                isArray: true
            }
        });
    });
