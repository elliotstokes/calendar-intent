var exec = require('cordova/exec');


exports.createEvent = function(options, success, failure) {
  exec(success, failure, 'CalendarIntent', 'createEvent', [options]);
};