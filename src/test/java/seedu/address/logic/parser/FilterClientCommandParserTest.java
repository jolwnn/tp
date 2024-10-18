package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FILTER;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterClientCommand;
import seedu.address.model.client.Name;

public class FilterClientCommandParserTest {

    private FilterClientCommandParser parser = new FilterClientCommandParser();
    private final String name = "Bob";
    @Test
    public void parse_nameSpecified_success() {
        // Test for valid phone number
        String userInput = FilterClientCommand.COMMAND_WORD + " " + PREFIX_FILTER + name;
        assertParseSuccess(parser, userInput, new FilterClientCommand(new Name(name)));
    }

    @Test
    public void parse_emptyName_failure() {
        // Test for empty phone number
        String userInput = FilterClientCommand.COMMAND_WORD + " " + PREFIX_FILTER + "";
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterClientCommand.MESSAGE_USAGE);
        assertParseFailure(parser, userInput, expectedMessage);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterClientCommand.MESSAGE_USAGE);
        // no parameters
        assertParseFailure(parser, FilterClientCommand.COMMAND_WORD, expectedMessage);
    }
}
