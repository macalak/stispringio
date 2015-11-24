"use strict";
(function (angular) {
    angular.module('library.books')

        .controller('BookCtrl', function ($scope, BookResource, $stateParams) {

            BookResource.get({id:$stateParams.id}).$promise
                .then(function(payload) {
                    $scope.book = payload;
                });

        });
}(angular || null));