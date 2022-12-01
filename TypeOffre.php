<?php

namespace App\Entity;

use App\Repository\TypeOffreRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: TypeOffreRepository::class)]
class TypeOffre
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    private ?string $nom = null;

    #[ORM\OneToMany(mappedBy: 'type', targetEntity: Offredemploi::class)]
    private Collection $Type;

    public function __construct()
    {
        $this->Type = new ArrayCollection();
    }





    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * @return Collection<int, Offredemploi>
     */
    public function getType(): Collection
    {
        return $this->Type;
    }

    public function addType(Offredemploi $type): self
    {
        if (!$this->Type->contains($type)) {
            $this->Type->add($type);
            $type->setType($this);
        }

        return $this;
    }

    public function removeType(Offredemploi $type): self
    {
        if ($this->Type->removeElement($type)) {
            // set the owning side to null (unless already changed)
            if ($type->getType() === $this) {
                $type->setType(null);
            }
        }

        return $this;
    }
}
