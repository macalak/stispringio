angular.module('library.books')

    .factory('BookResource', function ($resource) {
        'use strict';

        return $resource('library/api/book/:id', {id:'@id'}, {
            get: {
                method: 'GET',
                isArray: false
            }
        });

    });
