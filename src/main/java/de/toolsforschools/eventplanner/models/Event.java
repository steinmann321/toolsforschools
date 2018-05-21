package de.toolsforschools.eventplanner.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Event {
	@Id
	@GeneratedValue
	private Long id;
	private @NonNull String name;
	private Date targetDate;

	/**
	 * Creates the event object, due date passed as string
	 * @param name event name
	 * @param targetDateString String this uses a date string "dd.MM.yyyy"
	 * @throws ParseException it targetDateString cannot be parsed
	 */
	public Event(String name, String targetDateString) throws ParseException {
		this.name = name;
		this.targetDate = new SimpleDateFormat("dd.MM.yyyy").parse(targetDateString);
	}
}
