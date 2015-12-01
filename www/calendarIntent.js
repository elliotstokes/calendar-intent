var exec = require('cordova/exec');


exports.createEvent = function(options, success, failure) {
  exec(success, failure, 'CalendarIntent', 'createEvent', [options]);
};

exports.showCalendar = function(options, success, failure) {
  exec(success, failure, 'CalendarIntent', 'showCalendar', [options]);
};