$(document).ready(function() {
    notreadyye();
});

function notreadyye() {
    $('.notreadyyet').on('click', function() {
        alert("Not implemeted yet.")
    });
}

function l(m) { console.log(m);};
var tfcmanager = window.tfcmanager || {
    activeGradeId: 0,
    activeEventId: 0,
    toggleNavButton: function(el) {
        $('.list-group button').removeClass('active');
        el.addClass('active');
    },
    loadGrades: function(el) {
        el.load('/grades', function() {
            tfcmanager.bindGradesClickEvents();
        });
    },
    bindGradesClickEvents: function() {
        $('.grade-item').on('click', function() {
            var id = $(this).data('id');
            tfcmanager.activeGradeId = id;
            var evtid = "event-container-" + id;
            $('.events-list').hide();
            if(!$('#' + evtid).length ) {
                $('<div id=' + evtid + ' class="events-list"></div>').insertAfter($(this));
            }
            $('#' + evtid).load('/events', function() {
                tfcmanager.bindEventClickEvent();
            }).show();
            tfcmanager.toggleNavButton($(this));
       });
    },

    bindEventClickEvent: function() {
        $('.event-item').on('click', function() {
            var id = $(this).data('id');
            tfcmanager.activeEventId = id;
            $('#content').load('/todos/' + id + '/' + tfcmanager.activeGradeId, function() {
                notreadyye();
            });
            tfcmanager.toggleNavButton($(this));
        });
    },
};