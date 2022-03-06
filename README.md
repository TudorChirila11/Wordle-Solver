# Wordle
This java program solves a wordle, NYTimes Style.
It has 2 main modes:
## Automated mode - can be set by `play_mode="automated"`
* This gamemode roleplays as two players: 'the wizard' who randomly selects a 5-lettered word, and the computer, who tries to guess it in 6 tries. 
* 'The wizard' gives the computer the following feedback after each guessed word: 
  - 'B' for black (the letter does not exist in the word), 
  - 'Y' for yellow (the letter exists in the word, but not in this position)
  - 'G' fot green (the letter exist in the word, and is situated in the right position).

You can notice that the style is exactly the same as the NYTimes one, and the rules are the same.
## User Interaction Mode - can be set by `play_mode="literally anything"`
* In this gamemode, you know the correct word, and the computer tries to guess it. That means you have to give him a similar feedback after each guess.
* For example, if the word you're thinking at is "trial", and the computer guesses "alibi", you will then have to type 'YYGBB'

Don't ask me why the second 'i' isn't marked as Y, that's how NYT does it.

### Costumizing the "find word" engine

The `find_word` method from the `Word` class has two searching types: `brute` and not brute. 
  - the `brute` type finds the first valid word, and the computer returns it as a guess.
  - the `not-brute` type searches for the valid word with the largest number of different letters. this is particularly useful, for example, for the first guess of the computer, where he wants to get as much information about different letters as possible.

That's all for now, have fun with it!!
