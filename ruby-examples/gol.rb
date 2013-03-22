#!/usr/bin/env ruby

# Desirable OO properties:
#  - Each class is meaningful within the domain
#  - Classes obey tell don't ask
#  - Calls only go in one direction (no circular references)
#  - Methods are short and single purpose
#  - No sub-classes that should just be instances

class CellType
  def initialize(alive, required_neighbours)
    @required_neighbours = required_neighbours
    @alive = alive
  end

  def tick alive_neighbours
    spawn(@required_neighbours.include? alive_neighbours)
  end

  def alive?
    @alive
  end

 private

  def spawn alive
    return alive ? ALIVE_CELL : DEAD_CELL
  end
end

ALIVE_CELL = CellType.new(true, [2,3])
DEAD_CELL  = CellType.new(false, [3])

class World
  def initialize *alive_cell_positions
    @cells = {}

    for position in alive_cell_positions
      @cells[position] = ALIVE_CELL
    end
  end

  def tick
    populate_neighbours
    tick_cells
    remove_dead_cells
    self
  end

 private

  def populate_neighbours
    for position in @cells.keys
      for neighbouring_position in position.neighbourhood
        @cells[neighbouring_position] ||= DEAD_CELL
      end
    end
  end

  def tick_cells
    next_state = {}

    @cells.each do |position, cell|
      number_of_alive_neighbours = alive_cells_neighbouring(position).length
      next_state[position] = cell.tick(number_of_alive_neighbours)
    end

    @cells = next_state
  end

  def remove_dead_cells
    @cells.delete_if{ |p, c| not c.alive? }
  end

  def alive_cells_neighbouring position
    cells_neighbouring(position).find_all{|c| c.alive? }
  end

  def cells_neighbouring position
    position.neighbours.map do |position|
      @cells.fetch(position, DEAD_CELL)
    end
  end
end

class Position
  def initialize(x, y)
    @x = x
    @y = y
  end

  def neighbourhood
    neighbourhood = []

    for dx in [-1, 0, +1]
      for dy in [-1, 0, +1]
        neighbourhood.push(Position.new(@x + dx, @y + dy))
      end
    end

    return neighbourhood
  end

  def neighbours
    neighbourhood - [self]
  end

  def to_a
    [@x, @y]
  end

  def == o
    o.class == self.class &&
    o.to_a  == self.to_a
  end

  alias eql? ==

  def hash
    @x.hash ^ @y.hash
  end
end

# require "pp"
# 
# pp World.new(Position.new(1,2), Position.new(2,2), Position.new(3,2)).tick

