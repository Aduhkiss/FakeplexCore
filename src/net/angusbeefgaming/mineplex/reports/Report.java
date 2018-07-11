package net.angusbeefgaming.mineplex.reports;

import org.bukkit.OfflinePlayer;

public class Report {
	
	private static OfflinePlayer reporter;
	private static String target;
	private static String reason;
	private static boolean resolved;

	public Report(OfflinePlayer reporter, String target, String reason) {
		this.reporter = reporter;
		this.reason = reason;
		this.target = target;
		this.resolved = false;
	}
	
	public static OfflinePlayer getReporter() {
		return reporter;
	}
	
	public static String getTarget() {
		return target;
	}
	
	public static String getReason() {
		return reason;
	}
	
	public static boolean isResolved() {
		return resolved;
	}
	
	public static void setResolved() {
		resolved = true;
	}
}
