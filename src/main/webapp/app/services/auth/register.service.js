(function () {
    'use strict';

    angular
        .module('soatCodingChallengeApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
