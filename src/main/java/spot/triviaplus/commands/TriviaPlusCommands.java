package spot.triviaplus.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import com.mojang.brigadier.Command;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import spot.triviaplus.TriviaPlus;

public class TriviaPlusCommands {

	public static void register() {
		
		LifecycleEventManager<Plugin> manager = TriviaPlus.getInstance().getLifecycleManager();
		manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
			final Commands commands = event.registrar();
			commands.register(
				// TriviaPlus Main Command
				Commands.literal("triviaplus")
				// Trivia Start Sub-Command
				.then(Commands.literal("start")
					.executes(ctx -> {
						triviaStart(ctx.getSource().getSender());
						return Command.SINGLE_SUCCESS;
					})
				)
				// Trivia Stop Sub-Command
				.then(Commands.literal("stop")
					.executes(ctx -> {
						triviaStop(ctx.getSource().getSender());
						return Command.SINGLE_SUCCESS;
					})
				)
				// Trivia Help Sub-Command
				.then(Commands.literal("help")
					.executes(ctx -> {
						triviaHelp(ctx.getSource().getSender());
						return Command.SINGLE_SUCCESS;
					})
				)
				// No Sub-Command given
				.executes(ctx -> {
					triviaHelp(ctx.getSource().getSender());
					return Command.SINGLE_SUCCESS;
				})
				.build(),
				"TriviaPlus Main Command"
			);
		});

	}

	private static void triviaStart(@NotNull CommandSender sender) {
		// TODO Auto-generated method stub
		
	}

	private static void triviaStop(@NotNull CommandSender sender) {
		// TODO Auto-generated method stub
		
	}

	private static void triviaHelp(@NotNull CommandSender sender) {
		// TODO Auto-generated method stub
		
	}

}