/**
 * Created by pittner on 21.11.2015.
 */
var gulp = require('gulp');
var browserSync = require('browser-sync');
var connect = require('gulp-connect');
var proxy = require('proxy-middleware');

gulp.task('browserSync', function () {
    browserSync({
        server: {
            baseDir: ''
        }
    })
});

gulp.task('watch', ['browserSync'], function () {
    gulp.watch('**/*.*', browserSync.reload);
});

var fakeApiProxyMiddleware = proxy({
    hostname: 'localhost',
    port: 8080,
    pathname: '/m05p01-rest-solution',
    route: '/'
});

gulp.task('serve', function () {
    return connect.server({
        host: 'localhost',
        port: '8000',
        middleware: function (connect, options) {
            return [
                fakeApiProxyMiddleware
            ];
        }
    });
});
