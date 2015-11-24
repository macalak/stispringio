"use strict";
(function (angular) {
    angular.module('library.books')

        .controller('BooksCtrl', function ($scope, BooksResource) {

            BooksResource.query().$promise
                .then(function(payload) {
                    $scope.books = payload;
                });

        });
}(angular || null));